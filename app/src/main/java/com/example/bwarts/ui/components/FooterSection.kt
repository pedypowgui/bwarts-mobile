package com.example.bwarts.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bwarts.ui.theme.BwartsFooterBg
import com.example.bwarts.ui.theme.BwartsOrange
import com.example.bwarts.ui.theme.BwartsTextGray

@Composable
fun FooterSection(
    onLinkClick: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(BwartsFooterBg)
            .padding(top = 24.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Footer Brand Logo
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = BwartsOrange, fontWeight = FontWeight.Black, fontSize = 32.sp)) {
                    append("BW")
                }
                withStyle(style = SpanStyle(color = Color.White, fontWeight = FontWeight.Bold, fontSize = 32.sp)) {
                    append("arts")
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Social Media Icons (Instagram, Facebook, LinkedIn)
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SocialIconButton(onClick = { onLinkClick("Instagram") }) {
                // Custom Instagram Camera Outline Icon
                Canvas(modifier = Modifier.size(24.dp)) {
                    drawRoundRect(
                        color = Color.White,
                        style = Stroke(width = 2.dp.toPx()),
                        cornerRadius = androidx.compose.ui.geometry.CornerRadius(6.dp.toPx())
                    )
                    drawCircle(
                        color = Color.White,
                        radius = 5.dp.toPx(),
                        style = Stroke(width = 2.dp.toPx())
                    )
                    drawCircle(
                        color = Color.White,
                        radius = 1.5f.dp.toPx(),
                        center = Offset(size.width * 0.75f, size.height * 0.25f)
                    )
                }
            }

            SocialIconButton(onClick = { onLinkClick("Facebook") }) {
                // Facebook 'f' Icon
                Text(
                    text = "f",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            }

            SocialIconButton(onClick = { onLinkClick("LinkedIn") }) {
                // LinkedIn 'in' Icon
                Text(
                    text = "in",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Grid Content with 2 main columns
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Column 1: Contatos & Links rápidos
            Column(
                modifier = Modifier.weight(1f)
            ) {
                FooterHeader(text = "Contatos")
                FooterItemText(text = "gaiodoltosantoss@gmail.com")
                FooterItemText(text = "+55 (11) 99624-8706")
                FooterItemText(text = "+55 (11) 93127-2544")

                Spacer(modifier = Modifier.height(16.dp))

                FooterHeader(text = "Links rápidos")
                FooterClickableText(text = "Perguntas frequentes", onClick = { onLinkClick("Perguntas frequentes") })
                FooterClickableText(text = "Termos de uso", onClick = { onLinkClick("Termos de uso") })
                FooterClickableText(text = "Ajuda", onClick = { onLinkClick("Ajuda") })
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Column 2: Endereço & Meios de pagamento
            Column(
                modifier = Modifier.weight(1f)
            ) {
                FooterHeader(text = "Endereço")
                FooterItemText(text = "Rua Carlos de Carvalho, 7093 -")
                FooterItemText(text = "Jardim São José, SP, 08545-120")

                Spacer(modifier = Modifier.height(16.dp))

                FooterHeader(text = "Meios de pagamento")
                FooterItemText(text = "Preços e formas de pagamento são exclusivos para vendas via internet.")

                Spacer(modifier = Modifier.height(8.dp))

                // Payment Icons Row (Credit Card, Pix, Visa, Barcode)
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Credit card
                    Box(
                        modifier = Modifier
                            .size(width = 34.dp, height = 24.dp)
                            .background(Color(0xFF333336), RoundedCornerShape(4.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.CreditCard,
                            contentDescription = "Cartão de Crédito",
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                    }

                    // Pix (Diamond)
                    Box(
                        modifier = Modifier
                            .size(width = 34.dp, height = 24.dp)
                            .background(Color(0xFF333336), RoundedCornerShape(4.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Canvas(modifier = Modifier.size(14.dp)) {
                            val path = Path().apply {
                                moveTo(size.width / 2, 0f)
                                lineTo(size.width, size.height / 2)
                                lineTo(size.width / 2, size.height)
                                lineTo(0f, size.height / 2)
                                close()
                            }
                            drawPath(path = path, color = Color.White, style = Stroke(width = 1.8f.dp.toPx()))
                        }
                    }

                    // VISA Text Icon
                    Box(
                        modifier = Modifier
                            .size(width = 34.dp, height = 24.dp)
                            .background(Color(0xFF333336), RoundedCornerShape(4.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "VISA",
                            color = Color.White,
                            fontWeight = FontWeight.Black,
                            fontSize = 9.sp
                        )
                    }

                    // Barcode Icon
                    Box(
                        modifier = Modifier
                            .size(width = 34.dp, height = 24.dp)
                            .background(Color(0xFF333336), RoundedCornerShape(4.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.QrCode,
                            contentDescription = "Código de barras / Boleto",
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        HorizontalDivider(color = Color(0xFF3A3A3E), thickness = 1.dp)

        Spacer(modifier = Modifier.height(16.dp))

        // Copyright text
        Text(
            text = "© Copyright BWarts 2025. All rights reserved.",
            color = BwartsTextGray,
            fontSize = 11.sp
        )
    }
}

@Composable
private fun SocialIconButton(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .size(42.dp)
            .background(Color(0xFF2C2C30), CircleShape)
            .border(1.dp, Color(0xFF44444A), CircleShape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Composable
private fun FooterHeader(text: String) {
    Text(
        text = text,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        modifier = Modifier.padding(bottom = 6.dp)
    )
}

@Composable
private fun FooterItemText(text: String) {
    Text(
        text = text,
        color = BwartsTextGray,
        fontSize = 11.sp,
        lineHeight = 15.sp,
        modifier = Modifier.padding(vertical = 1.dp)
    )
}

@Composable
private fun FooterClickableText(text: String, onClick: () -> Unit) {
    Text(
        text = text,
        color = BwartsTextGray,
        fontSize = 11.sp,
        lineHeight = 15.sp,
        modifier = Modifier
            .padding(vertical = 2.dp)
            .clickable { onClick() }
    )
}
