package com.nao20010128nao.bindingviewholder

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

class BindingViewHolder<out T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)
