package js

import react.RProps

typealias Callback = (error: Any, t: TFunction) -> Unit

fun useTranslation(): (String) -> String {
    val jsTuple = rawUseTranslation()
    return jsTuple[0] as (String) -> String
}

class InitOptionsObject : InitOptions

class BackendOptionsObject : BackendOptions

class InterpolationsOptionsObject : InterpolationOptions

interface WithTranslationProps : RProps {
    var t: (String) -> String
}