package com.example.yummly_2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainAdapter(options: FirebaseRecyclerOptions<MainModel>) :
    FirebaseRecyclerAdapter<MainModel, MainAdapter.MyViewHolder>(options) {


    override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: MainModel) {
        holder.name.text = model.B_name
        holder.ingredient.text = model.C_ingredient
        holder.instruction.text = model.D_ingredient
        holder.origin.text = model.E_origin

        Glide.with(holder.img.context)
            .load(model.E_imageurl)
            .placeholder(com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark)
            .circleCrop()
            .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
            .into(holder.img)

        holder.editBtn.setOnClickListener {
            Toast.makeText(holder.name.context, "Editing the Recipe", Toast.LENGTH_SHORT).show()

            val dialogPlus = DialogPlus.newDialog(holder.img.context)
                .setContentHolder(ViewHolder(R.layout.show_update))
                .setExpanded(true, 1600)
                .create()

            val view = dialogPlus.holderView
            val name: EditText = view.findViewById(R.id.edit_name_recipe)
            val ingerdients:EditText = view.findViewById(R.id.edit_ingredients_recipe)
            val instruction:EditText = view.findViewById(R.id.edit_instructions_recipe)
            val img:EditText = view.findViewById(R.id.edit_)
            val btnUpdate:Button = view.findViewById(R.id.btn_id_update)

            name.setText(model.B_name)
            ingerdients.setText(model.C_ingerdients)
            instruction.setText(model.D_instruction)
            img.setText(model.E_imageurl)

            dialogPlus.show()
            btnUpdate.setOnClickListener {
                if (name.text.isEmpty()){
                    validateMsg("Name", holder.name.context)
                }else if (ingerdients.text.isEmpty()){
                    validateMsg("Ingerdients", holder.name.context)
                }else if (instruction.text.isEmpty()){
                    validateMsg("Instruction", holder.name.context)
                }else if (img.text.isEmpty()){
                    validateMsg("Picture", holder.name.context)
                }else{
                    val map = HashMap<String, Any>()
                    map["B_name"] = name.text.toString()
                    map["C_ingerdients"] = ingerdients.text.toString()
                    map["D_instruction"] = instruction.text.toString()
                    map["E_imageurl"] = img.text.toString()

                    FirebaseDatabase.getInstance().reference.child("values")
                        .child(getRef(position).key!!).updateChildren(map)
                        .addOnSuccessListener {
                            Toast.makeText(holder.name.context, "Recipe Update Successfully", Toast.LENGTH_SHORT).show()
                            dialogPlus.dismiss()
                        }
                        .addOnFailureListener {
                            Toast.makeText(holder.name.context, "Recipe Update Unsuccessfully", Toast.LENGTH_SHORT).show()
                            dialogPlus.dismiss()
                        }
                }
            }
        }

        holder.delete.setOnClickListener {
            Toast.makeText(holder.name.context, "Deleting the Recipe", Toast.LENGTH_SHORT).show()
            val builder = AlertDialog.Builder(holder.name.context)
            builder.setTitle("Attention")
            builder.setMessage("Are you sure you want to delete this Recipe?")
            builder.setPositiveButton("Yes"){ _, _ ->
                FirebaseDatabase.getInstance().reference.child("values")
                    .child(getRef(position).key!!).removeValue()
            }
            builder.setNegativeButton("No"){ dialog, _ ->
                Toast.makeText(holder.name.context, "Cancelled", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            }
            builder.show()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_character, parent, false)
        return MyViewHolder(view)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: CircleImageView = itemView.findViewById(R.id.img1_id)
        var name: TextView = itemView.findViewById(R.id.name_char_id)
        var ingredients: TextView = itemView.findViewById(R.id.ingredients_char_id)
        var instruction: TextView = itemView.findViewById(R.id.instruction_char_id)
        var editBtn: Button = itemView.findViewById(R.id.btn_edit)
        var deleteBtn: Button = itemView.findViewById(R.id.btn_delete)
    }


    //ito yung sa spinner
    private var adapterOrigin: ArrayAdapter<CharSequence>? = null
    private var listOrigin: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_update)

        // Initialize the Spinner
        listOrigin = findViewById(R.id.id_list_origin)

        // Create an ArrayAdapter using the string array and a default spinner layout
        adapterOrigin = createSpinnerAdapter(R.array.recipeOrigin)

        // Apply the adapter to the spinner
        listOrigin?.adapter = adapterOrigin
    }

    private fun createSpinnerAdapter(arrayResource: Int): ArrayAdapter<CharSequence> {
        // Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter.createFromResource(
            this,
            arrayResource,
            android.R.layout.simple_spinner_item
        )

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        return adapter
    }
}
