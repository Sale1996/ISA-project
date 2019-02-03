import axios from 'axios'

export const getUser = (id) => {

    return (dispatch, getState) => {

        axios.get('http://localhost:8096/api/user/user/' + id)
            .then(res => {
                console.log(res);
                dispatch({ type: 'GET_USER', user: res.data });
            })

    }

}

export const getUserFriendRequests = (id) => {

    return (dispatch, getState) => {

        axios.get('http://localhost:8096/api/user/user/friendRequest/' + id)
            .then(res => {
                console.log(res);
                dispatch({ type: 'GET_ALL_USERS_FRIEND_REQUESTS', friendRequests: res.data });
            })
    }
}

export const getUserFriends = (id) => {

    return (dispatch, getState) => {
        axios.get('http://localhost:8096/api/user/user/friends/' + id)
            .then(res => {
                console.log(res);
                dispatch({ type: 'GET_ALL_USER_FRIENDS', friends: res.data });
            })
    }
}

export const updateUser = (id, user) => {

    return (dispatch, getState) => {

        axios.put('http://localhost:8096/api/user/user/' + id, { id: user.id, name: user.name, surname: user.surname, city: user.city, email: user.email, telephoneNumber: user.telephoneNumber, passport: user.passport })
            .then(res => {
                console.log(res);
                dispatch({ type: 'USER_CHANGES_HIS_ATRIBUTES', user: res.data });
            })

    }

}