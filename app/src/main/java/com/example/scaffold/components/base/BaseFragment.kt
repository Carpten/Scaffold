package com.example.scaffold.components.base

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment {
    constructor() : super()
    constructor(contentLayoutId: Int) : super(contentLayoutId)
}