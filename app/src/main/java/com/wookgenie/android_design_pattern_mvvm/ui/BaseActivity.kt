package com.wookgenie.android_design_pattern_mvvm.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * BaseActivity
 * @author wookjin
 * @since 2023/06/14
 **/
abstract class BaseActivity<T : ViewDataBinding, R : BaseViewModel> : AppCompatActivity() {

    lateinit var binding: T
    abstract val TAG: String // 액티비티 태그
    /**
     * setContentView로 호출할 Layout의 리소스 Id
     * ex) R.layout.activity_main
     */
    abstract val layoutId: Int
    /**
     * viewModel 로 쓰일 변수
     */
    abstract val viewModel: R
    /**
     * 레이아웃을 띄운 직후 호출
     * 뷰나 액티비티의 속성 등을 초기화
     * ex) 리사이클러뷰, 툴바, 드로어뷰..
     */
    abstract fun initView()
    /**
     * 두번째로 호출
     * 데이터 바인딩 설정
     * ex) databinding observe..
     */
    abstract fun initDataBinding()
    /**
     * 바인딩 이후에 할 일을 여기에 구현
     * 그 외에 설정할 것이 있으면 이곳에서 설정
     * ex) 클릭 리스너..
     */
    abstract fun initAfterBinding()

//    lateinit var manager: SessionManager // 추후 세션매니저

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")
        // 초기화된 layoutResId로 databinding 객체 생성
        binding = DataBindingUtil.setContentView(this, layoutId)

        // live data를 사용하기 위해 해줘야함
        binding.lifecycleOwner = this@BaseActivity

        initView()
        initDataBinding()
        initAfterBinding()
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }
}