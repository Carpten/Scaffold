package com.example.scaffold.annotations


@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
@MustBeDocumented
annotation class OnClick(val ids: IntArray)