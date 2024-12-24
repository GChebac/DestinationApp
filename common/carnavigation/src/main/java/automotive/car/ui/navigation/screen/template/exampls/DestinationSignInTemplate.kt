package automotive.car.ui.navigation.screen.template.exampls

import android.util.Log
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.InputCallback
import androidx.car.app.model.Template
import androidx.car.app.model.signin.InputSignInMethod
import androidx.car.app.model.signin.SignInTemplate

class DestinationSignInTemplate(carContext: CarContext) : Screen(carContext) {

    override fun onGetTemplate(): Template {

        val signInMethod: InputSignInMethod =
            InputSignInMethod.Builder(InputCallbackImpl())
                .setInputType(InputSignInMethod.INPUT_TYPE_DEFAULT)
                .setHint("Enter your email address")
                .build()

        return SignInTemplate.Builder(signInMethod)
            .setTitle("Log In to Your Account")
            .setInstructions("Please enter your email address below:")
            .build()
    }


}
