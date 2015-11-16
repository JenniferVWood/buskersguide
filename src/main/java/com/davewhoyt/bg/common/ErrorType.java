package com.davewhoyt.bg.common;

/**
 * Rather than have a zillion kinds of Exception, let's just pass
 * the specific condition along with the Exception.
 *
 */
public enum ErrorType {
    UNKNOWN,
    USER_ALREADY_MADE_SUGGESTION,
    TOO_MANY_VOTES,
    CANNOT_VOTE_FOR_STAPLE,
    SNACK_NOT_FOUND,
    MISSING_VENDOR_LOCATION,
    MISSING_VENDOR_NAME,
    DUPLICATE_SUGGESTION;
}
