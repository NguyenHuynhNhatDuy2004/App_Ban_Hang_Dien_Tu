package com.example.appbanhangdientu.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appbanhangdientu.R
import com.example.appbanhangdientu.data.MockData
import com.example.appbanhangdientu.model.CartItem
import java.text.NumberFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    initialItems: List<CartItem> = MockData.sampleCartItems,
    onBackClick: () -> Unit = {},
    onCheckoutClick: () -> Unit = {}
) {
    val primaryColor = colorResource(R.color.purple)
    val formatter = NumberFormat.getCurrencyInstance(Locale.Builder().setLanguage("vi").setRegion("VN").build())
    val cartItems = remember { mutableStateListOf(*initialItems.toTypedArray()) }

    val subtotal = cartItems.sumOf { it.product.price * it.quantity }
    val shippingFee = if (cartItems.isEmpty()) 0.0 else 30000.0
    val totalPrice = subtotal + shippingFee

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Giỏ Hàng (${cartItems.sumOf { it.quantity }})", fontSize = 18.sp, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Image(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = "Back",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        bottomBar = {
            if (cartItems.isNotEmpty()) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shadowElevation = 8.dp,
                    color = Color.White
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Tạm tính:", color = Color.Gray)
                            Text(formatter.format(subtotal), fontWeight = FontWeight.SemiBold)
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 4.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Phí giao hàng:", color = Color.Gray)
                            Text(formatter.format(shippingFee), fontWeight = FontWeight.SemiBold)
                        }

                        HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Tổng cộng:", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                            Text(
                                formatter.format(totalPrice),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = primaryColor
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = onCheckoutClick,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
                        ) {
                            Text("Thanh Toán Ngay 🛍️", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        if (cartItems.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("🛒", fontSize = 64.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Giỏ hàng của bạn đang trống!", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text("Hãy chọn sản phẩm bạn yêu thích nhé", fontSize = 14.sp, color = Color.Gray)
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = onBackClick,
                        colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
                    ) {
                        Text("Khám Phá Sản Phẩm")
                    }
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color(0xFFF8F9FA)),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(cartItems) { item ->
                    CartItemRow(
                        cartItem = item,
                        onQuantityIncrease = {
                            val index = cartItems.indexOf(item)
                            if (index != -1) {
                                cartItems[index] = item.copy(quantity = item.quantity + 1)
                            }
                        },
                        onQuantityDecrease = {
                            val index = cartItems.indexOf(item)
                            if (index != -1) {
                                if (item.quantity > 1) {
                                    cartItems[index] = item.copy(quantity = item.quantity - 1)
                                } else {
                                    cartItems.removeAt(index)
                                }
                            }
                        },
                        onRemove = { cartItems.remove(item) }
                    )
                }
            }
        }
    }
}

@Composable
fun CartItemRow(
    cartItem: CartItem,
    onQuantityIncrease: () -> Unit,
    onQuantityDecrease: () -> Unit,
    onRemove: () -> Unit
) {
    val primaryColor = colorResource(R.color.purple)
    val formatter = NumberFormat.getCurrencyInstance(Locale.Builder().setLanguage("vi").setRegion("VN").build())

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = cartItem.product.imageResId),
                contentDescription = cartItem.product.title,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = cartItem.product.title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )

                Text(
                    text = formatter.format(cartItem.product.price),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = primaryColor,
                    modifier = Modifier.padding(vertical = 4.dp)
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        modifier = Modifier
                            .size(28.dp)
                            .clickable { onQuantityDecrease() },
                        shape = CircleShape,
                        color = Color(0xFFEEEEEE)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text("-", fontWeight = FontWeight.Bold)
                        }
                    }

                    Text(
                        text = "${cartItem.quantity}",
                        modifier = Modifier.padding(horizontal = 12.dp),
                        fontWeight = FontWeight.Bold
                    )

                    Surface(
                        modifier = Modifier
                            .size(28.dp)
                            .clickable { onQuantityIncrease() },
                        shape = CircleShape,
                        color = colorResource(R.color.LightPurple)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text("+", fontWeight = FontWeight.Bold, color = primaryColor)
                        }
                    }
                }
            }

            IconButton(onClick = onRemove) {
                Text("🗑️", fontSize = 18.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    CartScreen()
}
