package test.project.ywn.mvpcleanarchitecture.presentation.exception;

import android.content.Context;

import test.project.ywn.mvpcleanarchitecture.R;

/**
 * Created by root on 11/16/17.
 */

public class ErrorMessageFactory {

    private ErrorMessageFactory() {
        //empty
    }

    public static String create(Exception exception) {

        /*if (exception instanceof ) {
            message = context.getString(R.string.exception_message_no_connection);
        } else if (exception instanceof UserNotFoundException) {
            message = context.getString(R.string.exception_message_user_not_found);
        }*/

        return exception.getMessage();
    }
}