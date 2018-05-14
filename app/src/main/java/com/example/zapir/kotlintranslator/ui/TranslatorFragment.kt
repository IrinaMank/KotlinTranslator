package com.example.zapir.kotlintranslator.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import butterknife.BindArray
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.zapir.kotlintranslator.R

class TranslatorFragment: Fragment() {
    @BindArray(R.array.from_lang_array)
    lateinit var languagesArray: Array<String>

    @BindView(R.id.from_spinner)
    lateinit var fromLangSpinner: Spinner

    @BindView(R.id.to_spinner)
    lateinit var toLangSpinner: Spinner

    @BindView(R.id.swap_imageButton)
    lateinit var swapLangBtn: ImageButton

    @OnClick(R.id.swap_imageButton)
    fun swapLangs() {
        val fromLang = fromLangSpinner.selectedItemPosition
        fromLangSpinner.setSelection(toLangSpinner.selectedItemPosition)
        toLangSpinner.setSelection(fromLang)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_translator, container, false)
        ButterKnife.bind(this, view)
        //set Spinners
        val adapter = ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line,
                resources.getStringArray(R.array.from_lang_array))
        fromLangSpinner.adapter = adapter
        toLangSpinner.adapter = adapter
        return view
    }
}