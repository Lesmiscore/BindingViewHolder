package com.nao20010128nao.bindingviewholder.processor

import com.google.common.truth.Truth.assert_
import com.google.testing.compile.JavaFileObjects
import com.google.testing.compile.JavaSourceSubjectFactory.javaSource
import org.junit.Test

class Tests {
    @Test
    fun testDetection(){
        assert_().about(javaSource())
                .that(JavaFileObjects.forSourceString("android.databinding.TestBinding","""
                    @SuppressWarnings("Value")
                    @javax.annotation.processing.SupportedAnnotationTypes("")
                    public class TestBinding extends ViewDataBinding {}
                    @SuppressWarnings("Value")
                    @javax.annotation.processing.SupportedAnnotationTypes("")
                    class ViewDataBinding {}
                """.trimIndent()))
                .processedWith(Processor())
                .compilesWithoutError()
    }
}