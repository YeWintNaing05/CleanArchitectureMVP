package test.project.ywn.mvpcleanarchitecture.domain.exception;

/**
 * Created by root on 11/16/17.
 */

public interface ErrorBundle {
    Exception getException();

    String getErrorMessage();
}