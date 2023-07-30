package tw.edu.pu.csim.s1102294.asdfgh

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.View.INVISIBLE
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import org.w3c.dom.Text

class cvb2 : AppCompatActivity(), GestureDetector.OnGestureListener , View.OnTouchListener {
    lateinit var gDetector: GestureDetector
    lateinit var webView:WebView
    lateinit var webView2:WebView
    lateinit var txvc:TextView
    lateinit var txvtitle:TextView
    private var count: Int = 1

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cvb2)


        gDetector = GestureDetector(this, this)
        webView = findViewById(R.id.webView)
        webView2 = findViewById(R.id.webView2)
        txvc = findViewById(R.id.txvc)
        txvtitle = findViewById(R.id.txvtitle1)

        //val webView: WebView = findViewById(R.id.webView)

        // 启用 JavaScript 支持
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // 设置 WebChromeClient，以支持 JavaScript 的弹出窗口等特性
        webView.webChromeClient = WebChromeClient()

        // 加载 YouTube 视频的嵌入式 HTML 代码
        val htmlCode = "<iframe width=\"300\" height=\"200\" src=\"https://www.youtube.com/embed/ko0ZMyrM6uU\" title=\"《原神》钟离角色PV-「额外的记账」\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
        webView.loadData(htmlCode, "text/html", "utf-8")

        val webSettings2: WebSettings = webView2.settings
        webSettings2.javaScriptEnabled = true

        webView2.webChromeClient = WebChromeClient()

        val htmlCode2 = "<iframe width=\"300\" height=\"200\" src=\"https://www.youtube.com/embed/uzJGenQZT6Q\" title=\"《原神》角色演示 「鐘離：聽書人」\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
        webView2.loadData(htmlCode2, "text/html", "utf-8")

        webView.visibility = View.INVISIBLE     //View.VISIBLE顯示，INVISIBLE隱藏
        webView2.visibility = View.INVISIBLE
        txvtitle.text = "\n彭博\n"
        txvc.text = "中國內地的男性配音演員、配音導演、奇響天外工作室創始人。\n代表作：鍾離《原神》、齊格飛·卡斯蘭娜《崩壞3》、島田源氏《守望先鋒》、盧錫安《英雄聯盟》、董卓《三國殺》\n\n\n\n   < --------左右滑進入聲展-------- >"
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        gDetector.onTouchEvent(event)
        return true
    }

    override fun onDown(p0: MotionEvent): Boolean {
        return true
    }

    override fun onShowPress(p0: MotionEvent) {
    }

    override fun onSingleTapUp(p0: MotionEvent): Boolean {

        return true
    }

    override fun onScroll(e1: MotionEvent, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
        return true
    }

    override fun onLongPress(p0: MotionEvent) {

    }

    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        if (e1.x <= e2.x){
            count++
            if(count > 2) {
                count = 1
            }
        }
        else{
            count--
            if(count < 1) {
                count = 2
            }
        }
        var res:Int = getResources().getIdentifier("cv" + count.toString(),
            "drawable", getPackageName())
        if (count == 1){
            txvtitle.text = "\n彭博\n"
            txvc.text = "中國內地的男性配音演員、配音導演、奇響天外工作室創始人。\n代表作：鍾離《原神》、" +
                    "齊格飛·卡斯蘭娜《崩壞3》、島田源氏《守望先鋒》、盧錫安《英雄聯盟》、董卓《三國殺》\n\n\n\n"+
                    "   < --------左右滑進入聲展-------- >"
            webView.visibility = View.INVISIBLE
            webView2.visibility = View.INVISIBLE
        } else {
            txvtitle.text = "\n聲音展示"
            txvc.text = ""
            webView.visibility = View.VISIBLE
            webView2.visibility = View.VISIBLE
        }
        return true
    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }
}