package uz.apexsoft.domain.usecase.impl

import uz.apexsoft.domain.models.SaveUserDataParam
import uz.apexsoft.domain.repository.UserRepository
import uz.apexsoft.domain.usecase.SaveUserDataUseCase

class SaveUserDataUseCaseImpl(
    private val userRepository: UserRepository
) : SaveUserDataUseCase {

    override fun invoke(param: SaveUserDataParam): Boolean {
        val oldUserData = userRepository.getUserData()

        if (param.firstName.isNotBlank()) {
            if (oldUserData.firstName == param.firstName) {
                return true
            }
            return userRepository.saveUserData(saveParam = param)
        }
        return false
    }
}