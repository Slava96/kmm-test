@file:JsModule("react-i18next")
@file:JsNonModule

package js

import react.HOC
import react.RClass
import react.RProps

external var initReactI18next: ThirdPartyModule

@JsName("useTranslation")
external fun rawUseTranslation(): Array<dynamic>

external val withTranslation: HOC<RProps, WithTranslationProps>

