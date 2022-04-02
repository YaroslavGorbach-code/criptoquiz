package koropapps.criptoquiz.di.data

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import koropapps.criptoquiz.data.quizzes.local.QuizDatabase
import koropapps.criptoquiz.data.quizzes.local.dao.QuizResultDao
import koropapps.criptoquiz.data.quizzes.repo.RepoQuizzes
import koropapps.criptoquiz.data.quizzes.repo.RepoQuizzesImp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataQuizzesModule {

    @Singleton
    @Provides
    fun provideQuizzesRepo(quizResultDao: QuizResultDao): RepoQuizzes {
        return RepoQuizzesImp(quizResultDao)
    }

    @Singleton
    @Provides
    fun provideDatabase(app: Application): QuizDatabase {
        return Room.databaseBuilder(app, QuizDatabase::class.java, "db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideResultDao(db: QuizDatabase): QuizResultDao {
        return db.quizResult
    }
}