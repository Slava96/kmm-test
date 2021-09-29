@file:JsModule("i18next")
@file:JsNonModule

package js

import kotlin.js.Promise

@JsName("default")
external val i18next: i18n

external interface InitOptions {
    var debug: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var backend: BackendOptions?
        get() = definedExternally
        set(value) = definedExternally
    var fallbackLng: dynamic
        get() = definedExternally
        set(value) = definedExternally
    var supportedLngs: dynamic
        get() = definedExternally
        set(value) = definedExternally
    var ns: dynamic
        get() = definedExternally
        set(value) = definedExternally
    var defaultNS: String?
        get() = definedExternally
        set(value) = definedExternally
    var interpolation: InterpolationOptions?
        get() = definedExternally
        set(value) = definedExternally
}

external interface BackendOptions {
    var loadPath: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface TFunction {
    @nativeInvoke
    operator fun <TResult, TKeys> invoke(key: TKeys): dynamic
}

external interface InterpolationOptions {
    var escapeValue: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Module {
    var type: String
}

external interface BackendModule<TOptions> : Module {
    override var type: String
}

external interface LanguageDetectorModule : Module {
    override var type: String
}

external interface ThirdPartyModule : Module {
    override var type: String
}

external interface i18n {
    var t: TFunction
    fun init(options: InitOptions): Promise<TFunction>
    fun <T : Module> use(module: T): i18n
    var language: String
    fun changeLanguage(lng: String = definedExternally, callback: Callback = definedExternally): Promise<TFunction>
}