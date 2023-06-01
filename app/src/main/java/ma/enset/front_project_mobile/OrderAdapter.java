package ma.enset.front_project_mobile;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private List<OrderItem> orderItems;

    public OrderAdapter(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_order_item, parent, false);
        return new OrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        OrderItem orderItem = orderItems.get(position);

        holder.orderIdTextView.setText("Order " + orderItem.getOrderId());
        holder.statusTextView.setText(orderItem.getStatus());
        holder.quantityTextView.setText(orderItem.getProductList().size() + " product(s) ");
        holder.totalPriceTextView.setText("Price: " + orderItem.getTotalPrice());

        if (orderItem.getStatus().equals("PAID")) {
            holder.statusTextView.setTextColor(Color.GREEN);
        } else if (orderItem.getStatus().equals("UNPAID")) {
            holder.statusTextView.setTextColor(Color.parseColor("#FFA500")); // Orange color
        } else if (orderItem.getStatus().equals("CANCEL")) {
            holder.statusTextView.setTextColor(Color.GREEN);
        }
        holder.detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OrderDetailsActivity.class);
                intent.putExtra("orderId", orderItem.getOrderId());
                intent.putExtra("status", orderItem.getStatus());
                intent.putExtra("quantity", orderItem.getProductList().size());
                intent.putExtra("totalPrice", orderItem.getTotalPrice());
                intent.putExtra("productList", (Serializable) orderItem.getProductList());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView orderIdTextView;
        TextView statusTextView;
        TextView quantityTextView;
        TextView totalPriceTextView;
        Button detailsButton;

        public OrderViewHolder(View itemView) {
            super(itemView);
            orderIdTextView = itemView.findViewById(R.id.orderIdTextView);
            statusTextView = itemView.findViewById(R.id.statusTextView);
            quantityTextView = itemView.findViewById(R.id.quantityTextView);
            totalPriceTextView = itemView.findViewById(R.id.totalPriceTextView);
            detailsButton = itemView.findViewById(R.id.detailsButton);
        }
    }
}
