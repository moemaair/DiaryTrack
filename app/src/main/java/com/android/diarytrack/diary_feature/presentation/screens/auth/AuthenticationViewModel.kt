import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AuthenticationViewModel : ViewModel(){
    var loadingState = mutableStateOf(false)
        private set

    fun setLoading(loading: Boolean) {
        loadingState.value = loading
    }

    fun signInWithMongoAtlas(
        tokenId: String,
        onSuccess: () -> Unit,
        onError: (Exception) -> Unit
    ){

    }
}