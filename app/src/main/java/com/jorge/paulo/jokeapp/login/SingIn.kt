package com.jorge.paulo.jokeapp.login


import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jorge.paulo.jokeapp.R


private val String.isValidPassword: Boolean
    get() {
        return this.length >= 8
    }
private val String.isValidEmail: Boolean
    get() {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }
private val String.isValidName: Boolean
    get() {
        return this.length > 2
    }

@Composable
fun SingIn() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xff101010)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxSize()
        ) {
            Row() {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(
                            shape = RoundedCornerShape(12.dp)
                        )
                        .background(
                            color = Color(0xff171717)
                        )
                        .border(
                            border = BorderStroke(
                                width = 2.dp,
                                color = Color(0xff3E3E3E)
                            ),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .clickable {

                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                }
                Spacer(Modifier.width(24.dp))
                Text(
                    "Sign up",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
            }
            Spacer(Modifier.height(48.dp))
            Text(
                "Create an account for free to get started!",
                color = Color.White,
                fontSize = 15.sp
            )
            /////////////////////////////////////////
            Spacer(Modifier.height(24.dp))
            Text(
                "Name",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 9.dp)
            )
            Spacer(Modifier.height(13.dp))
            NameField()
            /////////////////////////////////////////
            Spacer(Modifier.height(24.dp))
            Text(
                "Email",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 9.dp)
            )
            Spacer(Modifier.height(13.dp))
            EmailField()
            /////////////////////////////////////////
            Spacer(Modifier.height(24.dp))
            Text(
                "Password",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 9.dp)
            )
            Spacer(Modifier.height(13.dp))
            PasswordField()
            /////////////////////////////////////
            Spacer(Modifier.height(18.dp))

            val buttonPressed = remember { mutableStateOf(false) }
            val buttonLeftColor = animateColorAsState(
                targetValue =
                if (buttonPressed.value)
                    Color(0xff480F63)
                else
                    Color(0xff3C28C6),
                animationSpec = tween(
                    durationMillis = 100,
                    easing = LinearEasing
                )
            )
            val buttonRightColor = animateColorAsState(
                targetValue =
                if (buttonPressed.value)
                    Color(0xff3C28C6)
                else
                    Color(0xff480F63),
                animationSpec = tween(
                    durationMillis = 100,
                    easing = LinearEasing
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                buttonLeftColor.value,
                                buttonRightColor.value
                            )
                        )
                    )
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onPress = {
                                buttonPressed.value = true
                            },
                            onTap = {
                                buttonPressed.value = false
                            }
                        )
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "SIGN UP",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    color = Color.Gray,
                    thickness = 2.dp
                )
                Text(
                    "OR",
                    modifier = Modifier.padding(16.dp),
                    color = Color.Gray
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    color = Color.Gray,
                    thickness = 2.dp
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .weight(1f)
                        .clip(shape = RoundedCornerShape(12.dp))
                        .clickable { }
                        .background(color = Color(0xff171717))
                        .border(
                            width = 2.dp,
                            color = Color(0xff252525),
                            shape = RoundedCornerShape(12.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.imag3),
                        contentDescription = "Google Login",
                        modifier = Modifier.size(40.dp),
                        tint = Color.White
                    )
                }
                Spacer(Modifier.width(18.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .weight(1f)
                        .clip(shape = RoundedCornerShape(12.dp))
                        .clickable { }
                        .background(color = Color(0xff171717))
                        .border(
                            width = 2.dp,
                            color = Color(0xff252525),
                            shape = RoundedCornerShape(12.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.img2),
                        contentDescription = "Google Login",
                        modifier = Modifier.size(40.dp),
                        tint = Color.White
                    )
                }
            }
            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Already have an account?",
                    color = Color.Gray
                )
                TextButton(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        "Log in",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun NameField() {
    val name = remember { mutableStateOf("") }
    val nameFocused = remember { mutableStateOf(false) }
    val nameFieldUpperBorderColor = animateColorAsState(
        targetValue =
        if (nameFocused.value)
            Color(0xff5133FF)
        else
            Color(0xff282828),
        animationSpec = tween(
            durationMillis = 300,
            easing = LinearEasing
        )
    )
    val nameFieldBottomBorderColor = animateColorAsState(
        targetValue =
        if (nameFocused.value)
            Color(0xff100F6C)
        else
            Color(0xff282828),
        animationSpec = tween(
            durationMillis = 300,
            easing = LinearEasing
        )
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .background(color = Color(0xff171717))
            .border(
                width = 2.dp,
                /*color = Color(0xff282828),*/
                shape = RoundedCornerShape(12.dp),
                brush = Brush.verticalGradient(
                    listOf(
                        nameFieldUpperBorderColor.value,
                        nameFieldBottomBorderColor.value
                    )
                )
            )
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                if (name.value.isEmpty()) {
                    Text(
                        "Name",
                        color = Color.Gray
                    )
                }
                BasicTextField(
                    value = name.value,
                    onValueChange = {
                        name.value = it
                    },
                    textStyle = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    ),
                    cursorBrush = SolidColor(Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged {
                            nameFocused.value = it.isFocused
                        }
                )
            }
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(shape = RoundedCornerShape(6.dp))
                    .background(
                        if (name.value.isValidName) Color(0xff282828) else Color.Transparent
                    ),
                contentAlignment = Alignment.Center
            ) {
                AnimatorVectorExample(name.value.isValidName)
            }
        }
    }
}

@Composable
private fun EmailField() {
    val email = remember { mutableStateOf("") }
    val emailFocused = remember { mutableStateOf(false) }
    val emailFieldUpperBorderColor = animateColorAsState(
        targetValue =
        if (emailFocused.value)
            Color(0xff5133FF)
        else
            Color(0xff282828),
        animationSpec = tween(
            durationMillis = 300,
            easing = LinearEasing
        )
    )
    val emailFieldBottomBorderColor = animateColorAsState(
        targetValue =
        if (emailFocused.value)
            Color(0xff100F6C)
        else
            Color(0xff282828),
        animationSpec = tween(
            durationMillis = 300,
            easing = LinearEasing
        )
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .background(color = Color(0xff171717))
            .border(
                width = 2.dp,
                /*color = Color(0xff282828),*/
                shape = RoundedCornerShape(12.dp),
                brush = Brush.verticalGradient(
                    listOf(
                        emailFieldUpperBorderColor.value,
                        emailFieldBottomBorderColor.value
                    )
                )
            )
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                if (email.value.isEmpty()) {
                    Text(
                        "Type your email address",
                        color = Color.Gray
                    )
                }
                BasicTextField(
                    value = email.value,
                    onValueChange = {
                        email.value = it
                    },
                    textStyle = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    ),
                    cursorBrush = SolidColor(Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged {
                            emailFocused.value = it.isFocused
                        },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    )
                )
            }
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(shape = RoundedCornerShape(6.dp))
                    .background(
                        if (email.value.isValidEmail) Color(0xff282828) else Color.Transparent
                    ),
                contentAlignment = Alignment.Center
            ) {
                AnimatorVectorExample(email.value.isValidEmail)
            }
        }
    }
}

@Composable
private fun PasswordField() {
    val password = remember { mutableStateOf("") }
    val passwordFocused = remember { mutableStateOf(false) }
    val passwordFieldUpperBorderColor = animateColorAsState(
        targetValue =
        if (passwordFocused.value)
            Color(0xff5133FF)
        else
            Color(0xff282828),
        animationSpec = tween(
            durationMillis = 300,
            easing = LinearEasing
        )
    )
    val passwordFieldBottomBorderColor = animateColorAsState(
        targetValue =
        if (passwordFocused.value)
            Color(0xff100F6C)
        else
            Color(0xff282828),
        animationSpec = tween(
            durationMillis = 300,
            easing = LinearEasing
        )
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .background(color = Color(0xff171717))
            .border(
                width = 2.dp,
                /*color = Color(0xff282828),*/
                shape = RoundedCornerShape(12.dp),
                brush = Brush.verticalGradient(
                    listOf(
                        passwordFieldUpperBorderColor.value,
                        passwordFieldBottomBorderColor.value
                    )
                )
            )
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                if (password.value.isEmpty()) {
                    Text(
                        "Type your email address",
                        color = Color.Gray
                    )
                }
                BasicTextField(
                    value = password.value,
                    onValueChange = {
                        password.value = it
                    },
                    textStyle = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    ),
                    cursorBrush = SolidColor(Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged {
                            passwordFocused.value = it.isFocused
                        },
                    visualTransformation = PasswordVisualTransformation()
                )
            }
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(shape = RoundedCornerShape(6.dp))
                    .background(
                        if (password.value.isValidPassword) Color(0xff282828) else Color.Transparent
                    ),
                contentAlignment = Alignment.Center
            ) {
                AnimatorVectorExample(password.value.isValidPassword)
            }
        }
    }
}

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
private fun AnimatorVectorExample(on: Boolean) {

    Image(
        painter = painterResource(id = R.drawable.imag3),
        contentDescription = "",
        modifier = Modifier
            .size(18.dp)
    )
}
