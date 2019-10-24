package com.leo.elegant.trunk.manager

import android.support.v4.app.Fragment
import android.util.SparseArray
import com.android.leo.base.GlobalConstant
import com.flyco.tablayout.listener.CustomTabEntity
import com.leo.elegant.trunk.R
import com.leo.elegant.trunk.entity.TabEntity
import com.sankuai.waimai.router.Router
import java.util.*

object TabManager {
    private val mTitles = arrayOf("vlog", "小视频", "我的")
    // 未被选中的图标
    private val mIconUnSelectIds = intArrayOf(R.mipmap.ic_home_normal, R.mipmap.ic_discovery_normal, R.mipmap.ic_mine_normal)
    // 被选中的图标
    private val mIconSelectIds = intArrayOf(R.mipmap.ic_home_selected, R.mipmap.ic_discovery_selected, R.mipmap.ic_mine_selected)
    private val mTabEntities = ArrayList<CustomTabEntity>()
    private val mFragments = ArrayList<Fragment>()
    private val mFragmentsArray = SparseArray<Fragment>()

    init {
        (0 until mTitles.size)
                .mapTo(mTabEntities) { TabEntity(mTitles[it], mIconSelectIds[it], mIconUnSelectIds[it]) }
    }

    public fun getTabEntities(): ArrayList<CustomTabEntity> {
        return mTabEntities
    }

    fun clearFragment() {
        mFragmentsArray.clear()
        mFragments.clear()
    }

    public fun getFragment(position: Int): Fragment {
        var fragment = mFragmentsArray.get(position)
        if (fragment != null) {
            return fragment
        } else {
            when (position) {
                0 -> {
                    fragment = Router.getServiceClass(Fragment::class.java,
                            GlobalConstant.Fragment.EYEPETIZER).newInstance()
                    mFragmentsArray.append(position, fragment)
                    mFragments.add(fragment)
                }
                1 -> {
                    fragment = Router.getServiceClass(Fragment::class.java,
                            GlobalConstant.Fragment.LITTLE_VIDEO).newInstance()
                    mFragmentsArray.append(position, fragment)
                    mFragments.add(fragment)
                }
                2 -> {
                    fragment = Router.getServiceClass(Fragment::class.java,
                            GlobalConstant.Fragment.MINE).newInstance()
                    mFragmentsArray.append(position, fragment)
                    mFragments.add(fragment)
                }

            }
            return fragment
        }

    }

    public fun getFragments(): ArrayList<Fragment> {
        return mFragments
    }
}