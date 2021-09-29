import js.useTranslation
import react.RProps
import react.dom.div
import react.functionalComponent

val TestMessage = functionalComponent<RProps> {
    val t = useTranslation()

    div {
        +t("testMessage")
    }
}