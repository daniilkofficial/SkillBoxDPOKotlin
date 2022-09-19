fun main() {
    var firstName = "Даниил"
    var lastName = "Каморницкий"
    var height = 196.66
    var weight = 78.8F
    var isChild = (height < 150.0) || (weight < 40.0F)
    var info = "$firstName $lastName \nВес: $height \nРост: $weight \nРебенок: $isChild"
    println(info + "\n")


    firstName = "Витя"
    lastName = "Купринов"
    height = 149.00
    isChild = (height < 150.0) || (weight < 40.0F)
    info = "$firstName $lastName \nВес: $height \nРост: $weight \nРебенок: $isChild"
    println(info + "\n")

    firstName = "Александр"
    lastName = "Крылов"
    height = 152.0
    weight = 30.01F
    isChild = (height < 150.0) || (weight < 40.0F)
    info = "$firstName $lastName \nВес: $height \nРост: $weight \nРебенок: $isChild"
    println(info)
}