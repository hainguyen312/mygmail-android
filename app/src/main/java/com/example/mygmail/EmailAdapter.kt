package com.example.mygmail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide // Thêm thư viện Glide để tải ảnh từ URL

data class Email(
    val sender: String,
    val subject: String,
    val content: String,
    val timestamp: String,
    val avatarUrl: String
)

class EmailAdapter(private val emailList: List<Email>) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewSender: TextView = itemView.findViewById(R.id.senderTextView)
        val textViewSubject: TextView = itemView.findViewById(R.id.subjectTextView)
        val textViewTimestamp: TextView = itemView.findViewById(R.id.timestampTextView)
        val avatarImageView: ImageView = itemView.findViewById(R.id.avatarImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_email, parent, false)
        return EmailViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emailList[position]
        holder.textViewSender.text = email.sender
        holder.textViewSubject.text = email.subject
        holder.textViewTimestamp.text = email.timestamp

        // Tải avatar bằng thư viện Glide
        Glide.with(holder.itemView.context)
            .load(email.avatarUrl)
            .circleCrop() // Cắt ảnh thành hình tròn
            .into(holder.avatarImageView)
    }

    override fun getItemCount(): Int {
        return emailList.size
    }
}
