import js.WithTranslationProps
import js.i18next
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import react.RBuilder
import react.RComponent
import react.RState
import react.dom.button
import react.dom.div
import react.dom.input
import react.setState
import react.child as childFunctional

interface WelcomeProps : WithTranslationProps {
}

data class WelcomeState(var lng: String, var inputValue: String) : RState

class Welcome(props: WelcomeProps) : RComponent<WelcomeProps, WelcomeState>(props) {
    override fun WelcomeState.init(props: WelcomeProps) {
        lng = i18next.language
        inputValue = ""
    }

    override fun RBuilder.render() {
        div {
            +"currentLanguage = ${state.lng}"
        }
        childFunctional(TestMessage) {}
        input(InputType.text) {
            attrs {
                placeholder = "Enter new language..."
                value = state.inputValue
                onChangeFunction = {
                    val input = it.target as HTMLInputElement
                    setState {
                        inputValue = input.value
                    }
                }
            }
        }
        button {
            attrs {
                onClickFunction = {
                    it.preventDefault()

                    i18next.changeLanguage(state.inputValue)
                    setState {
                        lng = inputValue
                    }
                }
            }
            +"Change language"
        }
    }
}
