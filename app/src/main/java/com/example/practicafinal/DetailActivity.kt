package com.example.practicafinal

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity




class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val university: University? = intent.getParcelableExtra("university")


        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val countryTextView: TextView = findViewById(R.id.countryTextView)
        val domainsTextView: TextView = findViewById(R.id.domainsTextView)
        val webTextView: TextView = findViewById(R.id.webTextView)


        if (university != null) {
            nameTextView.text = university.name
            countryTextView.text = university.country


            val domainsText = if (university.domains.isNotEmpty()) {
                university.domains.joinToString(", ")
            } else {
                "NO DEFINIDO."
            }

            domainsTextView.text = domainsText


            val webText = if (university.web_pages.isNotEmpty()) {
                university.web_pages.joinToString(", ")
            } else {
                "N/A"
            }


            val spannableString = SpannableString(webText)
            val color = Color.WHITE


            val linkStart = spannableString.indexOf(webText)
            val linkEnd = linkStart + webText.length


            val clickableSpan = object : ClickableSpan() {
                override fun onClick(widget: View) {

                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(webText))
                    startActivity(intent)
                }

                override fun updateDrawState(ds: TextPaint) {
                    super.updateDrawState(ds)

                    ds.color = color
                    ds.isUnderlineText = true
                }
            }

            spannableString.setSpan(clickableSpan, linkStart, linkEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)


            webTextView.text = spannableString
            webTextView.movementMethod = LinkMovementMethod.getInstance()
        } else {

        }
    }
}
