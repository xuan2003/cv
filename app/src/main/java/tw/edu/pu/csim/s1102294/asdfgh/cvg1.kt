package tw.edu.pu.csim.s1102294.asdfgh

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView

class cvg1 : AppCompatActivity(), GestureDetector.OnGestureListener , View.OnTouchListener {
    lateinit var gDetector: GestureDetector
    lateinit var webView: WebView
    lateinit var webView2: WebView
    lateinit var txvc: TextView
    lateinit var txvtitle: TextView
    private var count: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cvg1)


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
        val htmlCode1 = "<iframe width=\"300\" height=\"200\" src=\"https://www.youtube.com/embed/uTuBVfjt56g\" title=\"\u200E《原神》神里綾華角色PV——「白鷺歸庭」\u200E中配\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
        webView.loadData(htmlCode1, "text/html", "utf-8")


        val webSettings2: WebSettings = webView2.settings
        webSettings2.javaScriptEnabled = true

        webView2.webChromeClient = WebChromeClient()

        val htmlCode2 = "<iframe width=\"300\" height=\"200\" src=\"https://www.youtube.com/embed/v_QkcrKZ-Wc\" title=\"預告短片——「雪霽逢椿」｜原神\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
        webView2.loadData(htmlCode2, "text/html", "utf-8")

        webView.visibility = View.INVISIBLE     //View.VISIBLE顯示，INVISIBLE隱藏
        webView2.visibility = View.INVISIBLE
        txvtitle.text = "\n小N\n"
        txvc.text = "蔣麗，藝名shourei小N，簡稱小N，中國內地女性配音演員，奇響天外成員。\n\n代表角色有：《守望先鋒》黑影，《三色繪戀》墨小菊，《凹凸世界》艾比、秋，《崩壞3》麗塔·洛絲薇瑟、愛醬、杏·瑪爾，《戰雙帕彌什》露西亞，《原神》香菱、神里綾華、《崩壞興瓊鐵道》帕姆、停雲等。\n\n\n\n    < --------左右滑進入聲展-------- >"
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
            txvtitle.text = "\n小N\n"
            txvc.text = "蔣麗，藝名shourei小N，簡稱小N，中國內地女性配音演員，奇響天外成員。\n\n代表角色有：《守望先鋒》黑影，《三色繪戀》墨小菊，《凹凸世界》艾比、秋，《崩壞3》麗塔·洛絲薇瑟、愛醬、杏·瑪爾，《戰雙帕彌什》露西亞，《原神》香菱、神里綾華、《崩壞興瓊鐵道》帕姆、停雲等。\n\n\n\n    < --------左右滑進入聲展-------- >"
            webView.visibility = View.INVISIBLE
            webView2.visibility = View.INVISIBLE
        } else{
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