package oop_135150_suryanandadestiawan.week14

data class User(val name: String, val email: String, val age: Int)

class UserManager {
    // Business logic
    fun validateUser(user: User): Boolean {
        return user.email.contains("@") && user.age >= 18
    }

    // Database access
    fun saveUserToDatabase(user: User) {
        println("INSERT INTO users VALUES ('${user.name}', '${user.email}')")
    }

    // Email notification
    fun sendWelcomeEmail(user: User) {
        println("Sending email to: ${user.email}")
    }
}
