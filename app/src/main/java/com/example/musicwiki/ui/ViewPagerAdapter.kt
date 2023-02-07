package com.example.musicwiki.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

  private val mFragmentList = ArrayList<Fragment>()
  private val mFragmentTitleList = ArrayList<String>()

  override fun getCount(): Int {
    return mFragmentList.size
  }

  override fun getItem(position: Int): Fragment {
    return mFragmentList[position]
  }

  override fun getPageTitle(position: Int): CharSequence? {
    return mFragmentTitleList[position]
  }

  fun addFragment(fragment: Fragment, title: String) {
    mFragmentList.add(fragment)
    mFragmentTitleList.add(title)
  }
}