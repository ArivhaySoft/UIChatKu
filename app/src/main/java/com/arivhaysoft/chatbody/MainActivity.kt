package com.arivhaysoft.chatbody

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Html
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.get
import com.arivhaysoft.uichatku.ChatView
import com.arivhaysoft.uichatku.models.ChatMessage
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var mChatView: ChatView? = null
    var lastChat = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mChatView = this.rooster_chat_view


        val formatOutgoing = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
        val tz = TimeZone.getTimeZone("Asia/Jakarta")
        formatOutgoing.timeZone = tz
        val s = formatOutgoing.format(Calendar.getInstance().time)

        val myDate = s
        val sdf = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
        val date = sdf.parse(myDate)
        val startDate = date.time

        val chatMessage1 = ChatMessage("Selamat Datang di UIChatKu",startDate, ChatMessage.Type.RECEIVED)
        mChatView!!.addMessage(chatMessage1)

        val chatMessage2 = ChatMessage("Kirim Chat Kamau",startDate, ChatMessage.Type.SENT)
        mChatView!!.addMessage(chatMessage2)

        val chatMessage3 = ChatMessage("Dan Balas dengan menekan Tombol Balas yang ada di atas",startDate, ChatMessage.Type.RECEIVED)
        mChatView!!.addMessage(chatMessage3)

        button.setOnClickListener {

            val chatMessage = ChatMessage("Pesan : $lastChat Diterima Bro..",startDate, ChatMessage.Type.RECEIVED)
            mChatView!!.addMessage(chatMessage)

        }

        button2.setOnClickListener {
            mChatView!!.clearMessages()
        }
        mChatView!!.setOnSentMessageListener {
            lastChat = mChatView!!.typedMessage
            true
        }
    }

}
