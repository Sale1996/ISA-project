const initState = {

    user: {},
    useri: [],
    friends: [],
    friendRequests: []
}

const userReducer = (state = initState, action) => {

    switch (action.type) {
        case 'GET_USER':
            return {
                ...state,
                user: action.user
            }

        case 'GET_ALL_USERS':
            return {
                ...state,
                useri: action.users
            }

        case 'GET_ALL_USERS_FRIEND_REQUESTS':
            return {
                ...state,
                friendRequests: action.friendRequests
            }

        case 'GET_ALL_USER_FRIENDS':
            return {
                ...state,
                friends: action.friends
            }

        case 'USER_CHANGES_HIS_ATRIBUTES':
            return {
                ...state,
                user: action.user
            }
        default:
            break;
    }

    return state;

}

export default userReducer;

