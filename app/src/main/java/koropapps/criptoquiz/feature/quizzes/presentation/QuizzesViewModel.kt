package koropapps.criptoquiz.feature.quizzes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import koropapps.criptoquiz.feature.quizzes.model.QuizzesActions
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.launch
import yaroslavgorbach.reaction.business.exercises.MakeExerciseAvailableInteractor
import yaroslavgorbach.reaction.business.exercises.ObserveExercisesInteractor
import yaroslavgorbach.reaction.business.settings.ChangeIsFirstAppOpenToFalseInteractor
import yaroslavgorbach.reaction.business.settings.ObserveIsFirstAppOpenInteractor
import yaroslavgorbach.reaction.feature.esercises.model.ExercisesActions
import yaroslavgorbach.reaction.feature.esercises.model.ExercisesUiMassage
import yaroslavgorbach.reaction.feature.esercises.model.ExercisesViewState
import yaroslavgorbach.reaction.utill.AdManager
import yaroslavgorbach.reaction.utill.UiMessage
import yaroslavgorbach.reaction.utill.UiMessageManager
import javax.inject.Inject

@HiltViewModel
class QuizzesViewModel @Inject constructor(
) : ViewModel() {
    private val pendingActions = MutableSharedFlow<QuizzesActions>()

    val state: StateFlow<ExercisesViewState> = combine(
        observeExercisesInteractor(),
        exerciseAvailabilityDialogState,
        observeIsFirstAppOpenInteractor(),
        uiMessageManager.message,
        ::ExercisesViewState
    ).stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000),
        initialValue = ExercisesViewState.Empty
    )

    init {
        adManager.loadRewordAd()

        viewModelScope.launch {
            pendingActions.collect { action ->
                when (action) {
                    is ExercisesActions.HideExerciseIsNotAvailableDialog -> {
                        exerciseAvailabilityDialogState.emit(ExercisesViewState.ExerciseAvailabilityDialogState())
                    }
                    is ExercisesActions.ShowExerciseIsNotAvailableDialog -> {
                        exerciseAvailabilityDialogState.emit(
                            ExercisesViewState.ExerciseAvailabilityDialogState(
                                isVisible = true,
                                exerciseName = action.exerciseName
                            )
                        )
                    }
                    is ExercisesActions.HideOnboardingDialog -> {
                        changeIsFirstAppOpenToFalseInteractor.invoke()
                    }
                    is ExercisesActions.RequestShowRewordAd -> {
                        uiMessageManager.emitMessage(
                            UiMessage(
                                ExercisesUiMassage.ShowRewardAd(
                                    action.exerciseName
                                )
                            )
                        )
                    }
                    is ExercisesActions.ShowRewordAd -> {
                        adManager.showRewardAd(
                            activity = action.activity,
                        ) {
                            viewModelScope.launch {
                                makeExerciseAvailableInteractor.invoke(exerciseName = action.exerciseName)
                            }
                        }
                    }
                    else -> error("$action is not handled")
                }
            }
        }
    }

    fun submitAction(action: ExercisesActions) {
        viewModelScope.launch {
            pendingActions.emit(action)
        }
    }

    fun clearMessage(id: Long) {
        viewModelScope.launch {
            uiMessageManager.clearMessage(id)
        }
    }

}



