package com.example.linkit.domain.interfaces

import com.example.linkit.domain.model.log

interface ListMapper<I, O> : Mapper<List<I>, List<O>>

open class ListMapperImpl<I, O>(
    private val mapper: Mapper<I, O>
) : ListMapper<I, O> {
    override fun map(input: List<I>): List<O> {
        "인풋 리스트 길이 ${input.size}".log()
        return input.map { mapper.map(it) }
    }
}