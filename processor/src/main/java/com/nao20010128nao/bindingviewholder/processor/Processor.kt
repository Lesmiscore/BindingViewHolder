package com.nao20010128nao.bindingviewholder.processor

import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedAnnotationTypes
import javax.annotation.processing.SupportedSourceVersion
import javax.lang.model.SourceVersion
import javax.lang.model.element.ElementKind
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic

@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SupportedAnnotationTypes("*")
class Processor : AbstractProcessor() {
    override fun process(types: MutableSet<out TypeElement>?, round: RoundEnvironment?): Boolean {
        round!!
        types!!
        val dataBinding = processingEnv!!.elementUtils!!.getPackageElement("android.databinding.ViewDataBinding")!!
        types.flatMap { round.getElementsAnnotatedWith(it) }
                .also { it.forEach { processingEnv.messager.printMessage(Diagnostic.Kind.NOTE, "1", it) } }
                .filter { it.kind == ElementKind.CLASS }
                .also { it.forEach { processingEnv.messager.printMessage(Diagnostic.Kind.NOTE, "2", it) } }
                .map { it as TypeElement }
                .also { it.forEach { processingEnv.messager.printMessage(Diagnostic.Kind.NOTE, "3", it) } }
                .filter { it.superclass == dataBinding || it.toString() == dataBinding.toString() }
                .forEach { processingEnv.messager.printMessage(Diagnostic.Kind.NOTE, "Found", it) }
        return true
    }
}