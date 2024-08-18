package nextstep.shoppingcart

import android.icu.text.NumberFormat
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import nextstep.shoppingcart.ui.theme.ProductImageHeight
import nextstep.shoppingcart.ui.theme.ProductImageWidth
import nextstep.shoppingcart.ui.theme.ProductNameBottomPadding
import nextstep.shoppingcart.ui.theme.ProductNameMaxLine
import java.util.Locale

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProductItem(product: Product, modifier: Modifier = Modifier) {
    Column {
        GlideImage(
            model = product.imageUrl,
            contentDescription = product.name,
            loading = placeholder(R.drawable.ic_launcher_foreground),
            modifier = modifier.size(
                width = ProductImageWidth,
                height = ProductImageHeight
            ),
        )
        Text(
            text = product.name,
            modifier = modifier.padding(bottom = ProductNameBottomPadding),
            maxLines = ProductNameMaxLine,
            overflow = TextOverflow.Ellipsis
        )
        val formattedPrice =
            NumberFormat.getNumberInstance(Locale.KOREAN).format(product.price)
        Text(text = "${formattedPrice}원")
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    ProductItem(dummyProducts.first())
}