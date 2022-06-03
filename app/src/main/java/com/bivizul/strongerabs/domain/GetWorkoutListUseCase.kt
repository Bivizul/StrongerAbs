package com.bivizul.strongerabs.domain

class GetWorkoutListUseCase(private val repository: Repository) {

    suspend operator fun invoke() = repository.getWorkoutList()

}