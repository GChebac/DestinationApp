package automotive.car.ui.navigation.screen.template.exampls

import android.util.Log
import androidx.car.app.model.InputCallback

class InputCallbackImpl : InputCallback {

    override fun onInputSubmitted(inputText: String) {
        Log.d("onInputSubmitted", inputText)

        if (isValidEmail(inputText)) {
            //
        } else {
            //
            Log.e("SignIn", "Invalid email address")
        }
    }

    override fun onInputTextChanged(inputText: String) {
        Log.d("onInputTextChanged", inputText)
        //validator.isEmailValid(inputText) ...
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}