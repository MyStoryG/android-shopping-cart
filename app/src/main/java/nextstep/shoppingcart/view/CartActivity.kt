package nextstep.shoppingcart.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CartScreen()
        }
    }
}
