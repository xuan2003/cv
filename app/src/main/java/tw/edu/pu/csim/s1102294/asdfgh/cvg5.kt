package tw.edu.pu.csim.s1102294.asdfgh

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.TextView

class cvg5 : AppCompatActivity(), GestureDetector.OnGestureListener , View.OnTouchListener {
    lateinit var gDetector: GestureDetector
    lateinit var txvc: TextView
    lateinit var txvtitle: TextView
    lateinit var txvt1: TextView
    lateinit var play: Button
    lateinit var stop: Button
    lateinit var txvt2: TextView
    lateinit var play2: Button
    lateinit var stop2: Button
    lateinit var txvt3: TextView
    lateinit var play3: Button
    lateinit var stop3: Button
    private var count: Int = 1
    var mper = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cvg5)


        gDetector = GestureDetector(this, this)
        txvc = findViewById(R.id.txvc)
        txvtitle = findViewById(R.id.txvtitle1)
        txvt1 = findViewById(R.id.txvt1)
        txvt2 = findViewById(R.id.txvt2)
        txvt3 = findViewById(R.id.txvt3)
        play = findViewById(R.id.play)
        play.setOnClickListener {
            mper.reset()
            mper = MediaPlayer.create(this, R.raw.s9)
            mper.start()
        }
        stop = findViewById(R.id.stop)
        stop.setOnClickListener {
            mper.stop()
        }
        play2 = findViewById(R.id.play2)
        play2.setOnClickListener {
            mper.reset()
            mper = MediaPlayer.create(this, R.raw.s10)
            mper.start()
        }
        stop2 = findViewById(R.id.stop2)
        stop2.setOnClickListener {
            mper.stop()
        }
        play3 = findViewById(R.id.play3)
        play3.setOnClickListener {
            mper.reset()
            mper = MediaPlayer.create(this, R.raw.s11)
            mper.start()
        }
        stop3 = findViewById(R.id.stop3)
        stop3.setOnClickListener {
            mper.stop()
        }
        txvt1.visibility = View.INVISIBLE
        play.visibility = View.INVISIBLE
        stop.visibility = View.INVISIBLE
        txvt2.visibility = View.INVISIBLE
        play2.visibility = View.INVISIBLE
        stop2.visibility = View.INVISIBLE
        txvt3.visibility = View.INVISIBLE
        play3.visibility = View.INVISIBLE
        stop3.visibility = View.INVISIBLE
        txvtitle.text = "\n金喵兒\n"
        txvc.text = "不吃素的金喵兒，音域廣，少女音、御姊音、奶奶音、富婆音、正太音等。B站：不吃素的金喵儿 （周末随缘游戏直播） 喜馬拉雅：不吃素的金喵儿 （周一、周四晚6-9点 唱歌、游戏、Pia戏、录音直播）。\n\n廣播劇：《撿到一隻貓，喵喵喵》果果、《我們都要好好的》許虞等。\n\n\n\n   < --------左右滑進入聲展-------- >"
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
            txvtitle.text = "\n金喵兒\n"
            txvc.text = "不吃素的金喵兒，惡人谷配音員，音域廣，少女音、御姊音、奶奶音、富婆音、正太音等。B站：不吃素的金喵儿 （周末随缘游戏直播） 喜馬拉雅：不吃素的金喵儿 （周一、周四晚6-9点 唱歌、游戏、Pia戏、录音直播）。\n\n廣播劇：《撿到一隻貓，喵喵喵》果果、《我們都要好好的》許虞等。\n\n\n\n   < --------左右滑進入聲展-------- >"
            txvt1.visibility = View.INVISIBLE
            play.visibility = View.INVISIBLE
            stop.visibility = View.INVISIBLE
            txvt2.visibility = View.INVISIBLE
            play2.visibility = View.INVISIBLE
            stop2.visibility = View.INVISIBLE
            txvt3.visibility = View.INVISIBLE
            play3.visibility = View.INVISIBLE
            stop3.visibility = View.INVISIBLE
        } else {
            txvtitle.text = "\n聲音展示"
            txvc.text = ""
            txvt1.visibility = View.VISIBLE
            play.visibility = View.VISIBLE
            stop.visibility = View.VISIBLE
            txvt2.visibility = View.VISIBLE
            play2.visibility = View.VISIBLE
            stop2.visibility = View.VISIBLE
            txvt3.visibility = View.VISIBLE
            play3.visibility = View.VISIBLE
            stop3.visibility = View.VISIBLE
            txvt1.text = "云深春晚-金喵兒\n"
            txvt2.text = "今晚月色真美-金喵兒&水母\n"
            txvt3.text = "狐言-金喵兒(念白+歌)\n"
        }
        return true
    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }
}