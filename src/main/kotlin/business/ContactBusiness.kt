package business

import entity.ContactEntity
import repository.ContactRepository

class ContactBusiness {

    private fun validate(name : String, phone : String) {
        if(name == "") {
            throw Exception("Nome é obrigatório!")
        }

        if(phone == "" ) {
            throw Exception("Telefone é obrigatório!")
        }
    }

    fun save(name : String, phone : String) {
        validate(name, phone)
        val contact = ContactEntity(name, phone)
        ContactRepository.save(contact)

    }

    fun getContactCountDescription() : String {
        val list = getList()
        return when {
            list.isEmpty() -> "0 contatos"
            else -> "${list.size} contatos"
        }
    }

     fun delete(name : String, phone : String) {
        validateDelete(name, phone)
        val contact = ContactEntity(name, phone)
        ContactRepository.delete(contact)
    }

    private fun validateDelete(name : String, phone : String) {
        if(name == "" || phone == "") {
            throw Exception("É necessário selecionar um contato antes de remover.")
        }
    }

    fun getList() : List<ContactEntity>{
        return ContactRepository.getList()
    }
}