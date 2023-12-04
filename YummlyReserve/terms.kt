package com.example.yummly_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yummly_2.databinding.ActivityTermsBinding

class terms : AppCompatActivity() {
    private lateinit var binding: ActivityTermsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.idTosTxt.text= " Welcome to Yummly, the Recipe App for culinary enthusiasts! By accessing or using our app, you agree to comply with and be bound by the following Terms of Service. Please read these terms carefully before using Yummly.\n" +
                "\n" +
                "        1. Acceptance of Terms: By using Yummly, you agree to these Terms of Service. If you do not agree, please do not use the app.\n" +
                "\n" +
                "        2. Use of the App: Yummly is intended for personal, non-commercial use. You may not use it for any illegal or unauthorized purpose. You agree to comply with all applicable laws.\n" +
                "\n" +
                "        3. User Accounts: To access certain features, you may need to create a user account. You are responsible for maintaining the confidentiality of your account information.\n" +
                "\n" +
                "        4. Content: Yummly allows users to share and customize recipes. You are solely responsible for the content you post. We reserve the right to remove any content that violates these terms.\n" +
                "\n" +
                "        5. Intellectual Property: All content and materials on Yummly are protected by intellectual property laws. You may not use, reproduce, or distribute any content without permission.\n" +
                "\n" +
                "        6. Privacy: Please review our Privacy Policy to understand how we collect, use, and protect your personal information.\n" +
                "\n" +
                "        7. Modification of Terms: We reserve the right to update or modify these terms at any time. Your continued use of Yummly after changes constitutes acceptance of the modified terms.\n" +
                "\n" +
                "        8. Termination: We may terminate or suspend your account if you violate these terms. You may also terminate your account at any time.\n" +
                "\n" +
                "        9. Disclaimer: Yummly is provided \"as is\" without any warranties. We are not responsible for the accuracy or reliability of content posted by users.\n" +
                "\n" +
                "        10. Contact Us: If you have any questions about these terms, please contact us at [contact.yummly@kurtic.com]."
        binding.idPpTxt.text ="Welcome to Yummly, the Recipe App committed to your privacy! This Privacy Policy explains how we collect, use, and protect your personal information.\n" +
                "\n" +
                "        1. Information We Collect:\n" +
                "        - User Account Information: When you create an account, we collect your username and email address.\n" +
                "        - Usage Data: We collect information about how you use Yummly, such as recipes viewed and customized.\n" +
                "\n" +
                "        2. How We Use Your Information:\n" +
                "         - Personalization: We use your information to personalize your Yummly experience, including recipe recommendations.\n" +
                "         - Communication: We may contact you with app updates, newsletters, or important notices.\n" +
                "\n" +
                "        3. Sharing of Information:\n" +
                "         - Public Content: Content you share on Yummly may be visible to other users.\n" +
                "         - Third-Party Services: We may share non-personal information with third-party service providers.\n" +
                "\n" +
                "        4. Your Choices:\n" +
                "         - Account Settings: You can customize your privacy settings within the app.\n" +
                "         - Communications: You can opt-out of promotional emails.\n" +
                "\n" +
                "        5. Security:\n" +
                "         - We use industry-standard measures to protect your information, but no method is 100% secure.\n" +
                "\n" +
                "        6. Children’s Privacy:\n" +
                "         - Yummly is not intended for children under 13. We do not knowingly collect information from children.\n" +
                "\n" +
                "        7. Changes to the Privacy Policy:\n" +
                "         - We may update this Privacy Policy. Check the effective date for the latest version.\n" +
                "\n" +
                "        8. Contact Us:\n" +
                "         - If you have questions or concerns, contact us at [contact.yummly@kurtic.com].\n" +
                "\n" +
                "        By using Yummly, you agree to this Privacy Policy."
    }
}