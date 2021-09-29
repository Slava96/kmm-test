import js.*
import react.*
import kotlinx.browser.document
import kotlinx.browser.window
import react.dom.render
import react.rClass
import kotlin.js.Promise

fun main() {
    window.onload = {
        localizationInit().then {
            render(document.getElementById("root")) {
                child(Welcome::class) {

                }
            }
        }
    }
}


fun localizationInit(): Promise<TFunction> {
    val loadPath = "${window.location.pathname.removeSuffix("/")}/locales/{{lng}}/{{ns}}.json"
    return i18next
        .use(initReactI18next)
        .use(Backend)
        .use(LanguageModule)
        .init(
            InitOptionsObject().apply {
                debug = true
                backend = BackendOptionsObject().apply {
                    this.loadPath = loadPath
                }
                interpolation = InterpolationsOptionsObject().apply {
                    escapeValue = false
                }
                fallbackLng = "en"
                supportedLngs = arrayOf("ru", "en")
                ns = "translation"
                defaultNS = "translation"
            }
        )
}