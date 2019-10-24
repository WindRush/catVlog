package com.shortvideo.android.leo.mvp.model

import com.agile.android.leo.mvp.BaseModel
import com.shortvideo.android.leo.mvp.VideoListConstant
import com.shortvideo.android.leo.mvp.contract.SmallVideoContract
import com.shortvideo.android.leo.mvp.model.entity.VideoBean
import io.reactivex.Observable
import org.json.JSONObject

class SmallVideoModel : SmallVideoContract.Model, BaseModel() {
    override fun getVideoData(): Observable<ArrayList<VideoBean>> {
        val videoList = ArrayList<VideoBean>()
        videoList.addAll(getVideoNetList())
        videoList.add(VideoBean("火焰，燃烧吧~",
                "http://p9.pstatp.com/large/4c87000639ab0f21c285.jpeg",
                "https://aweme.snssdk.com/aweme/v1/play/?video_id=97022dc18711411ead17e8dcb75bccd2&line=0&ratio=720p&media_type=4&vr_type=0", 0))

        videoList.add(VideoBean("每次去商场就这样，挑来挑去。",
                "http://p1.pstatp.com/large/4bea0014e31708ecb03e.jpeg",
                "https://aweme.snssdk.com/aweme/v1/play/?video_id=374e166692ee4ebfae030ceae117a9d0&line=0&ratio=720p&media_type=4&vr_type=0", 0))

        videoList.add(VideoBean("鹿港小镇最亮的仔~",
                "http://p1.pstatp.com/large/4bb500130248a3bcdad0.jpeg",
                "https://aweme.snssdk.com/aweme/v1/play/?video_id=8a55161f84cb4b6aab70cf9e84810ad2&line=0&ratio=720p&media_type=4&vr_type=0", 0))

        videoList.add(VideoBean("test1",
                "http://p9.pstatp.com/large/4b8300007d1906573584.jpeg",
                "https://aweme.snssdk.com/aweme/v1/play/?video_id=47a9d69fe7d94280a59e639f39e4b8f4&line=0&ratio=720p&media_type=4&vr_type=0", 0))

        videoList.add(VideoBean("test1",
                "http://p9.pstatp.com/large/4b61000b6a4187626dda.jpeg",
                "https://aweme.snssdk.com/aweme/v1/play/?video_id=3fdb4876a7f34bad8fa957db4b5ed159&line=0&ratio=720p&media_type=4&vr_type=0", 0))


        videoList.add(VideoBean("七舅脑爷| 脑爷烧脑三重奏，谁动了我的蛋糕",
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2018/03/2018-03-30_10-1782811316-750x420.jpg",
                "http://cdnxdc.tanzi88.com/XDC/dvideo/2018/03/29/8b5ecf95be5c5928b6a89f589f5e3637.mp4", 1));

        videoList.add(VideoBean("七舅脑爷| 你会不会在爱情中迷失了自我，从而遗忘你正拥有的美好？",
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2018/02/2018-02-09_23-573150677-750x420.jpg",
                "http://cdnxdc.tanzi88.com/XDC/dvideo/2018/02/29/056bf3fabc41a1c1257ea7f69b5ee787.mp4", 1));

        videoList.add(VideoBean("七舅脑爷| 别因为你的患得患失，就怀疑爱情的重量",
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2018/02/2018-02-23_57-2208169443-750x420.jpg",
                "http://cdnxdc.tanzi88.com/XDC/dvideo/2018/02/29/db48634c0e7e3eaa4583aa48b4b3180f.mp4", 1));

        videoList.add(VideoBean("七舅脑爷| 女员工遭老板调戏，被同事陷害，双面夹击路在何方？",
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/12/2017-12-08_39-829276539-750x420.jpg",
                "http://cdnxdc.tanzi88.com/XDC/dvideo/2017/12/29/fc821f9a8673d2994f9c2cb9b27233a3.mp4", 1));

        videoList.add(VideoBean("七舅脑爷| 夺人女友，帮人作弊，不正经的学霸比校霸都可怕。",
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2018/01/2018-01-05_49-2212350172-750x420.jpg",
                "http://cdnxdc.tanzi88.com/XDC/dvideo/2018/01/29/bc95044a9c40ec2d8bdf4ac9f8c50f44.mp4", 1));

        videoList.add(VideoBean("七舅脑爷| 男子被困秘密房间上演绝命游戏, 背后凶手竟是他?",
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/11/2017-11-10_10-320769792-750x420.jpg",
                "http://cdnxdc.tanzi88.com/XDC/dvideo/2017/11/29/15f22f48466180232ca50ec25b0711a7.mp4", 1));

        videoList.add(VideoBean("七舅脑爷| 男人玩心机，真真假假，我究竟变成了谁？",
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/11/2017-11-03_37-744135043-750x420.jpg",
                "http://cdnxdc.tanzi88.com/XDC/dvideo/2017/11/29/7c21c43ba0817742ff0224e9bcdf12b6.mp4", 1));

        return Observable.just(videoList)
    }

    private fun getVideoNetList():  ArrayList<VideoBean>{
        val jsonVideos = JSONObject(VideoListConstant.videos)
        val videoSet =  ArrayList<VideoBean>()
        jsonVideos.getJSONArray("data")?.let { it ->
            for (i in 0 until it.length()) {
                val jsonItem = JSONObject(it.get(i).toString())
                videoSet.add(VideoBean(titles[i%titles.size],
                        jsonItem.getString("thumbImageUrl"),
                        jsonItem.getString("url")))
            }
        }

        return videoSet
    }

    private val titles = arrayListOf<String>(
            "花有重开日，人无再少年🤣🤣🤣🤣",
            "怎么会爱上他💋💋💋😍😍😍😘",
            "💤💤💤黄花映日别样红",
            "~~~~~~~~sing a song~~~~~~!!!🌂🌂🌂",
            "你比以前坚强💋💋💋💋",
            "我不是无情的人，却把你伤的最深",
            "生死之交一碗酒✊🤛✊🤜🤜",
            "靠近一点，suprise~~👨👱‍♀️👳‍♀️",
            "团长，👮‍👨👱‍♀️️👮俺喜欢你~",
            "时间一点一点的走",
            "咚巴拉黑~",
            "咕咕噜噜，咕咕噜噜，，，。。",
            "就这两个菜，喝酒你尽快😁😁😁😁😁🤣",
            "biubiubiu~",
            "冲天香气透长安，满城尽带黄金甲🐯🐯🐯",
            "还记得那时夕阳下的奔跑，那是我逝去的青春~"
    )
}