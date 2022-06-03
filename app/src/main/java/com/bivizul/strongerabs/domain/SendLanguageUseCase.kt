package com.bivizul.strongerabs.domain

import java.util.*

class SendLanguageUseCase(private val repository: Repository) {

    suspend operator fun invoke(send: Locale) = repository.sendLanguage(send)

}