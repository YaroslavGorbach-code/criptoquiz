package koropapps.criptoquiz.di.data

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import koropapps.criptoquiz.data.quizzes.repo.RepoQuizzes
import koropapps.criptoquiz.data.quizzes.repo.RepoQuizzesImp

@Module
@InstallIn(SingletonComponent::class)
class DataQuizzesModule {

    @Provides
    fun provideQuizzesRepo(app: Application): RepoQuizzes {
        return RepoQuizzesImp(app.applicationContext)
    }
}