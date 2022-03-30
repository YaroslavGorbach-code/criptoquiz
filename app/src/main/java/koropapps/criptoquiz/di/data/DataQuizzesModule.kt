package koropapps.criptoquiz.di.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import koropapps.criptoquiz.data.quizzes.repo.RepoQuizzes
import koropapps.criptoquiz.data.quizzes.repo.RepoQuizzesImp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataQuizzesModule {

    @Singleton
    @Provides
    fun provideQuizzesRepo(): RepoQuizzes {
        return RepoQuizzesImp()
    }
}