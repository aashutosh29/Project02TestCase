package jlin2.examples.localtesting

import org.junit.Assert.*
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun validEmail_standardFormat_returnsTrue() {
        val email = "123@abc.com"
        assertTrue(EmailValidator.isValidEmail(email))
    }

    @Test
    fun validEmail_subdomainFormat_returnsTrue() {
        val email = "123@abc.co.ca"
        assertTrue(EmailValidator.isValidEmail(email))
    }

    @Test
    fun invalidEmail_missingDomain_returnsFalse() {
        val email = "123@abc"
        assertFalse(EmailValidator.isValidEmail(email))
    }

    @Test
    fun invalidEmail_doubleDots_returnsFalse() {
        val email = "123@abc..com"
        assertFalse(EmailValidator.isValidEmail(email))
    }

    @Test
    fun invalidEmail_noUsername_returnsFalse() {
        val email = "@abc.com"
        assertFalse(EmailValidator.isValidEmail(email))
    }

    @Test
    fun invalidEmail_noAtSymbolOrDomain_returnsFalse() {
        val email = "testing123"
        assertFalse(EmailValidator.isValidEmail(email))
    }

    @Test
    fun invalidEmail_emptyString_returnsFalse() {
        val email = ""
        assertFalse(EmailValidator.isValidEmail(email))
    }

    @Test
    fun invalidEmail_null_returnsFalse() {
        val email: String? = null
        assertFalse(EmailValidator.isValidEmail(email))
    }
}