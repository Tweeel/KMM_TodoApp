import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import data.MongoDB
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.dsl.module
import presentation.screens.home.HomeScreen
import presentation.screens.home.HomeViewModel
import presentation.screens.task.TaskViewModel
import ui.theme.TodoAppTheme

@Composable
fun App() {
    initKoin()
    TodoAppTheme {
        Navigator(HomeScreen()){
            SlideTransition(it)
        }
    }
}


class ViewModelFactory : KoinComponent {
    inline fun <reified  T: ScreenModel> getViewModel(): T {
        val viewModel: T by inject()
        return viewModel
    }
}


val mongoModule = module {
    single { MongoDB() }
    factory { HomeViewModel(get()) }
    factory { TaskViewModel(get()) }
}

fun initKoin() {
    // Start Koin
    startKoin {
        // declare used modules
        modules(mongoModule)
    }
}
