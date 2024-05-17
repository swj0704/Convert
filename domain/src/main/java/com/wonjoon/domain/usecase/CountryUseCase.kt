package com.wonjoon.domain.usecase

import com.wonjoon.domain.model.CountryModel
import com.wonjoon.domain.model.enums.Country
import com.wonjoon.domain.repository.CountryRepository

class CountryUseCase(val repository: CountryRepository) {
    operator fun invoke() : List<Country>{
        return repository.getCountries()
    }
}