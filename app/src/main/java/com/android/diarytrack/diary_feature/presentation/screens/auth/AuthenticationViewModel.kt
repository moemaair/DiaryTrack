import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AuthenticationViewModel : ViewModel(){
    var loadingState = mutableStateOf(false)
        private set
}