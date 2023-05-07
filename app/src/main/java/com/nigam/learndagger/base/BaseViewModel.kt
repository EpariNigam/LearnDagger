package com.nigam.learndagger.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

open class BaseViewModel {
    val scope = CloseableCoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
}
